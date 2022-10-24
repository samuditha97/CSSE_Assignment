package com.se3070_we_43.util;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import com.se3070_we_43.util.Constants;

public class XSLTransformUtil extends CommonUtil {

    private static final ArrayList<Map<String, String>> responseList = new ArrayList<>();

    public static ArrayList<Map<String, String>> xmlPaths() throws Exception {

        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder()
                .parse(Constants.EMPLOYEE_RESPONSE);
        XPath xPath = XPathFactory.newInstance().newXPath();
        int count = Integer.parseInt((String) xPath.compile("count(//Employees/Employee)").evaluate(document, XPathConstants.STRING));
        for (int i = 1; i <= count; i++) {
            Map<String, String> map = new HashMap<>();
            map.put("XpathEmployeeIDKey", (String) xPath.compile(Constants.EMPLOYEE_PATH +"["+ i + "]/"+Constants.EMPLOYEE_ID+"/text()")
                    .evaluate(document, XPathConstants.STRING));
            map.put("XpathEmployeeNameKey", (String) xPath.compile(Constants.EMPLOYEE_PATH +"[" + i + "]/"+Constants.EMPLOYEE_FULL_NAME+"/text()")
                    .evaluate(document, XPathConstants.STRING));
            map.put("XpathEmployeeAddressKey",
                    (String) xPath.compile(Constants.EMPLOYEE_PATH +"[" + i + "]/"+Constants.EMPLOYEE_FULL_ADDRESS+"/text()")
                            .evaluate(document, XPathConstants.STRING));
            map.put("XpathFacultyNameKey", (String) xPath.compile(Constants.EMPLOYEE_PATH +"["+ i + "]/"+Constants.FACULTY_NAME+"/text()")
                    .evaluate(document, XPathConstants.STRING));
            map.put("XpathDepartmentKey", (String) xPath.compile(Constants.EMPLOYEE_PATH +"["+ i + "]/"+Constants.DEPARTMENT+"/text()")
                    .evaluate(document, XPathConstants.STRING));
            map.put("XpathDesignationKey", (String) xPath.compile(Constants.EMPLOYEE_PATH +"["+ i + "]/"+Constants.DESIGNATION+"/text()")
                    .evaluate(document, XPathConstants.STRING));
            responseList.add(map);
        }
        return responseList;
    }
}
