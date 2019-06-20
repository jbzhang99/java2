package com.rfchina.community.component;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.rfchina.community.persistence.mapper.SensitiveWordsMapper;
import com.rfchina.community.persistence.mapper.ext.ExtSensitiveWordsMapper;
import com.rfchina.community.persistence.model.SensitiveWords;
import com.rfchina.community.persistence.model.SensitiveWordsExample;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 */
@Component
public class SensitiveWordsComponent {

    private Cache<String, List<SensitiveWords>> SENSITIVE_WORDS_LIST_CACHE = CacheBuilder.newBuilder()
            .expireAfterWrite(10, TimeUnit.SECONDS)
            .build();

    public static final String CACHE_KEY_PREFIX = "ca_sensitive_words_";

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private SensitiveWordsMapper mapper;

    @Autowired
    private ExtSensitiveWordsMapper extMapper;

    @PostConstruct
    public void init() {
//        reloadCache();
    }

    public void reloadCache() {
        List<Integer> communityIdList = extMapper.selectCommunityIdList();
        if(CollectionUtils.isNotEmpty(communityIdList)) {
            for(Integer communityId : communityIdList) {
                SensitiveWordsExample example = new SensitiveWordsExample();
                example.createCriteria().andCommunityIdEqualTo(communityId);
                List<SensitiveWords> wordsList = mapper.selectByExample(example);
                if(CollectionUtils.isNotEmpty(wordsList)) {
                    String cacheKey = CACHE_KEY_PREFIX + communityId;
                    SENSITIVE_WORDS_LIST_CACHE.put(cacheKey, wordsList);
                    logger.info("reloadCache for communityId:{}", communityId);
                }
            }
        }
    }

    public String replaceSensitiveWords(Integer communityId, final String source) {
        logger.info("Invoke [replaceSensitiveWords] for communityId:{}, source:{}", communityId, source);
        if(null == communityId) {
            logger.warn("communityId is null");
            return source;
        }
        List<SensitiveWords> list = getSensitiveWordsList(communityId);
        String filteredSource = source;
        if(CollectionUtils.isNotEmpty(list)) {
            for(SensitiveWords item : list) {
                String words = item.getWords();
                String rplWords = item.getRplWords();
                filteredSource = StringUtils.replace(filteredSource, words, rplWords);
            }
            logger.info("source[{}] and filtered source[{}]", source, filteredSource);
        } else {
            logger.info("[replaceSensitiveWords] has no sensitive words list for communityId:{}", communityId);
        }
        return filteredSource;
    }

    public List<SensitiveWords> getSensitiveWordsList(Integer communityId) {
        SensitiveWordsExample example = new SensitiveWordsExample();
        example.createCriteria().andCommunityIdEqualTo(communityId);
        List<SensitiveWords> wordsList = mapper.selectByExample(example);
        return wordsList;
    }

    public List<String> importFromExcel(InputStream inputStream, Integer communityId) throws IOException {
        Date now = new Date();
        List<String> list = new ArrayList<>();
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(0);     //获得第一个表单
        if(null != sheet) {
            Iterator<Row> rowIterator = sheet.rowIterator();
            int i = 0;
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();  //获得行数据
                int rowNum = row.getRowNum();
                int actualRowNum = rowNum + 1;
                if(rowNum ==0) {    //第一行是标题，过滤掉
                    continue;
                }
                String result = "";
                Cell cell1 = row.getCell(1);
                String words = cell1.getStringCellValue();
                if(StringUtils.isBlank(words)) {
                    result = String.format("行号[%d]的敏感词列为空", actualRowNum);
                    list.add(result);
                    continue;
                }
                Cell cell2 = row.getCell(2);
                String rplWords = cell2.getStringCellValue();
                if(StringUtils.isBlank(words)) {
                    result = String.format("行号[%d]的替换词列为空", actualRowNum);
                    list.add(result);
                    continue;
                }

                Long cid = hasWords(words, communityId);
                if(null != cid) {
                    SensitiveWords updateRecord = new SensitiveWords();
                    updateRecord.setId(cid);
                    updateRecord.setRplWords(rplWords);
                    updateRecord.setUpdateTime(now);
                    int j = mapper.updateByPrimaryKeySelective(updateRecord);
                    if(1 == j) {
                        result = String.format("行号[%s]的敏感词替换成功", actualRowNum);
                    } else {
                        logger.info("行号[%d]未做如何替换操作", actualRowNum);
                    }
                } else {
                    SensitiveWords insertRecord = new SensitiveWords();
                    insertRecord.setCommunityId(communityId);
                    insertRecord.setWords(words);
                    insertRecord.setRplWords(rplWords);
                    insertRecord.setCreateTime(now);
                    insertRecord.setUpdateTime(now);
                    int k = mapper.insertSelective(insertRecord);
                    if(1 == k) {
                        result = String.format("行号[%s]的敏感词导入成功", actualRowNum);
                    } else {
                        logger.info("行号[%d]未做如何操作导入操作", actualRowNum);
                    }
                }
                list.add(result);
            }
        }
        return list;
    }

    private Long hasWords(String words, Integer communityId) {
        SensitiveWordsExample example = new SensitiveWordsExample();
        example.createCriteria().andCommunityIdEqualTo(communityId)
                .andWordsEqualTo(words);
        List<SensitiveWords> list = mapper.selectByExample(example);
        return CollectionUtils.isNotEmpty(list)? list.get(0).getId():null;
    }
}
