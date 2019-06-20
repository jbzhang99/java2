package com.rfchina.community.openweb.shiro;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;

public class OpenWebRedisSessionDAO extends AbstractSessionDAO {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private static final String KEY_PREFIX = "openweb_";

    private RedisTemplate<Object, Object> redisTemplate;

    public OpenWebRedisSessionDAO(RedisTemplate<Object, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    protected Serializable doCreate(Session session) {
        Serializable sessionId = this.generateSessionId(session);
        this.assignSessionId(session, sessionId);
        this.saveSession(session);
        return sessionId;
    }

    @Override
    protected Session doReadSession(Serializable sessionId) {
        if(sessionId == null){
            logger.warn("session id is null");
            return null;
        }
        Session s = (Session) redisTemplate.opsForValue().get(createCacheKey(sessionId));
        return s;
    }

    @Override
    public void update(Session session) throws UnknownSessionException {
        this.saveSession(session);
    }

    private void saveSession(Session session) throws UnknownSessionException {
        if(session == null || session.getId() == null) {
            logger.error("session or session id is null");
            return;
        }
        redisTemplate.opsForValue().set(createCacheKey(session.getId()), session);
    }

    @Override
    public void delete(Session session) {
        if(session == null || session.getId() == null) {
            logger.error("session or session id is null");
            return;
        }
        redisTemplate.delete(createCacheKey(session.getId()));
    }

    @Override
    public Collection<Session> getActiveSessions() {
        Set<Session> sessions = new HashSet<Session>();

        Set<Object> keys = redisTemplate.keys(KEY_PREFIX + "*");
        if(keys != null && keys.size()>0){
            for(Object key : keys) {
                Session s = (Session) redisTemplate.opsForValue().get(key);
                sessions.add(s);
            }
        }
        return sessions;
    }

    private String createCacheKey(Serializable id) {
        String cacheKey = KEY_PREFIX + id;
        return cacheKey;
    }
}
