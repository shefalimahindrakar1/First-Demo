package com.firstdemo.core.servlets;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.testing.mock.sling.servlet.MockSlingHttpServletRequest;
import org.apache.sling.testing.mock.sling.servlet.MockSlingHttpServletResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith({AemContextExtension.class})
class AdditionServletTest {
    AdditionServlet additionServlet=new AdditionServlet();

    @BeforeEach
    void setUp() {
    }

    @Test
    void doGet(AemContext aemContext) throws IOException, ServletException {
        MockSlingHttpServletRequest request=aemContext.request();
        MockSlingHttpServletResponse response=aemContext.response();
        Map<String, Object> paraMap=new HashMap<String, Object>();
        paraMap.put("first",12);
        paraMap.put("second",12);
        request.setParameterMap(paraMap);
        additionServlet.doGet(request,response);
        assertEquals(24,Integer.parseInt(response.getOutputAsString().trim()));
    }
    }
//comment needed