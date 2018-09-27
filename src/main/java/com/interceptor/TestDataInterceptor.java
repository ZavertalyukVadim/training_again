package com.interceptor;

import com.helper.TestDataUploader;
import com.repository.UserRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.Instant;

@Log
@Component
public class TestDataInterceptor implements HandlerInterceptor {
    private final UserRepository userRepository;
    private final TestDataUploader testDataUploader;

    @Autowired
    public TestDataInterceptor(UserRepository userRepository,
                               TestDataUploader testDataUploader) {
        this.userRepository = userRepository;
        this.testDataUploader = testDataUploader;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (userRepository.findAll().isEmpty()) {
            testDataUploader.addTestData();
        }
        request.setAttribute("time", Instant.now().toEpochMilli());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        Long time = (Long) request.getAttribute("time");
        long timeDifference = Instant.now().toEpochMilli() - time;
        log.warning("time of request is =  " + timeDifference);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
