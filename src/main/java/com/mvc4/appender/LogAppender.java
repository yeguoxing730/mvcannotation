package com.mvc4.appender;

import org.apache.log4j.DailyRollingFileAppender;
import org.apache.log4j.Priority;

/**
 * Created by yeguoxing on 2018/3/7.
 */
public class LogAppender  extends DailyRollingFileAppender {
    /**
     * 只记录这个级别的日志
     * @param priority
     * @return
     */
    @Override
    public boolean isAsSevereAsThreshold(Priority priority) {
        return this.getThreshold().equals(priority);
    }
}
