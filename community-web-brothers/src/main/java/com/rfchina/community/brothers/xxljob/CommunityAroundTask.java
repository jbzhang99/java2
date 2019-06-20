package com.rfchina.community.brothers.xxljob;

import com.rfchina.community.brothers.service.CommunityAroundManageBrotherService;
import com.rfchina.community.persistence.model.ext.ExtCommunityAroundPoi;
import com.rfchina.community.service.openser.CommunityAroundPoiService;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName CommunityAroundTask
 * @Description 拉取数据
 * @Author wlrllr
 * @Date 2019/4/26 13:11
 * @Version 1.0
 **/
@Component
public class CommunityAroundTask{

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private CommunityAroundManageBrotherService communityAroundManageBrotherService;


    @JobHandler(value = "brothers-CommunityAroundTask-SyncCommunityInfo")
    @Component
    class CommunityAroundTaskSyncCommunityInfo extends IJobHandler{
        @Override
        public ReturnT<String> execute(String s) throws Exception {
            this.syncCommunityInfo();
            return ReturnT.SUCCESS;
        }

        /**
         * @Author wlrllr
         * @Description //比对新增的社区，或者是修改了经纬度的社区，将其添加到执行计划中
         * @Date 2019/5/7
         * @Param []
         * @return void
         **/
        public void syncCommunityInfo() {
            logger.info("同步社区经纬度和新增的社区信息...");
            communityAroundManageBrotherService.syncCommunityInfo();
        }
    }

    @JobHandler(value = "brothers-CommunityAroundTask-ExecuteUpdatePlan")
    @Component
    class CommunityAroundTaskExecuteUpdatePlan extends IJobHandler{
        @Override
        public ReturnT<String> execute(String s) throws Exception {
            this.executeUpdatePlan();
            return ReturnT.SUCCESS;
        }

        /**
         * @Author wlrllr
         * @Description //执行周边社区商户更新计划
         * @Date 2019/5/8
         * @Param []
         * @return void
         **/
        public void executeUpdatePlan() {
            logger.info("执行周边社区商户更新计划,重新拉取社区周边信息...");
            communityAroundManageBrotherService.executeUpdatePlan();
        }
    }

    @JobHandler(value = "brothers-CommunityAroundTask-SyncPoiExtInfo")
    @Component
    class CommunityAroundTaskSyncPoiExtInfo extends IJobHandler{
        @Override
        public ReturnT<String> execute(String s) throws Exception {
            this.syncPoiExtInfo();
            return ReturnT.SUCCESS;
        }

        /**
         * @Author wlrllr
         * @Description //更新百度商户信息
         * @Date 2019/5/8
         * @Param []
         * @return void
         **/
        public void syncPoiExtInfo(){
            logger.info("拉取百度商户信息...");
            communityAroundManageBrotherService.syncPoiExtInfoTask();
        }
    }

    @JobHandler(value = "brothers-CommunityAroundTask-ParsePoiData")
    @Component
    class CommunityAroundTaskParsePoiData extends IJobHandler{
        @Override
        public ReturnT<String> execute(String s) throws Exception {
            this.parsePoiData();
            return ReturnT.SUCCESS;
        }

        /**
         * @Author wlrllr
         * @Description //解析商户数据
         * @Date 2019/5/8
         * @Param []
         * @return void
         **/
        public void parsePoiData(){
            communityAroundManageBrotherService.parsePoiData();
        }
    }

    @JobHandler(value = "brothers-CommunityAroundTask-UploadPoiPic")
    @Component
    class UploadPoiPic extends IJobHandler{
        @Override
        public ReturnT<String> execute(String s) throws Exception {
            this.uploadPoiPic();
            return ReturnT.SUCCESS;
        }

        /**
         * @Author wlrllr
         * @Description //解析商户数据
         * @Date 2019/5/8
         * @Param []
         * @return void
         **/
        public void uploadPoiPic(){
            communityAroundManageBrotherService.uploadPoiPic();
        }
    }

    @JobHandler(value = "brothers-CommunityAroundTask-ConvertLocation")
    @Component
    class ConvertLocation extends IJobHandler{
        @Override
        public ReturnT<String> execute(String s) throws Exception {
            this.convertLocation();
            return ReturnT.SUCCESS;
        }

        /**
         * @Author wlrllr
         * @Description //解析商户数据
         * @Date 2019/5/8
         * @Param []
         * @return void
         **/
        public void convertLocation(){
            communityAroundManageBrotherService.convertLocation();
        }
    }

    @JobHandler(value = "brothers-CommunityAroundTask-SyncPoiComment")
    @Component
    class SyncPoiComment extends IJobHandler{
        @Override
        public ReturnT<String> execute(String s) throws Exception {
            this.syncPoiComment();
            return ReturnT.SUCCESS;
        }

        /**
         * @Author wlrllr
         * @Description //解析商户数据
         * @Date 2019/5/8
         * @Param []
         * @return void
         **/
        public void syncPoiComment(){
            communityAroundManageBrotherService.syncPoiComment();
        }
    }

    @JobHandler(value = "brothers-CommunityAroundTask-RefreshPoiDistance")
    @Component
    class RefreshPoiDistance extends IJobHandler{
        @Override
        public ReturnT<String> execute(String s) throws Exception {
            this.refreshDistance();
            return ReturnT.SUCCESS;
        }

        /**
         * @Author wlrllr
         * @Description //社区经纬度改变后，重新刷新商户到社区的距离
         * @Date 2019/5/7
         * @Param []
         * @return void
         **/
        public void refreshDistance() {
            logger.info("重新计算社区到经纬度距离...");
            communityAroundManageBrotherService.refreshDistance();
        }
    }
}
