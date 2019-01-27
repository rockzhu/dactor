/*
 * @(#)ActorBeanDefinitionParser.java	1.0 2014年5月16日 上午9:42:26
 *
 * Copyright 2004-2010 Client Server International, Inc. All rights reserved.
 * CSII PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package cn.ymotel.dactor.spring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.DOMConfiguration;
import org.w3c.dom.Document;
import org.w3c.dom.Element;  
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSSerializer;
import org.springframework.util.StringUtils;  



/**
 * {type specification, must edit}
 *
 * @author  Administrator {must edit, use true name}
 * <p>
 *   Created on 2014年5月16日
 *   Modification history	
 *   {add your history}
 * </p>
 * @version 1.0
 * @since 1.0
 */
public class ActorGlobalDefinitionParser extends AbstractSingleBeanDefinitionParser {
	 protected Class getBeanClass(Element element) {  
	        return HashMap.class;  
	    }  
	 
	 @Override
	protected void doParse(Element element, ParserContext parserContext, BeanDefinitionBuilder builder) {
		 
		 
		
		 
//		 System.out.println(str);

		 super.doParse(element, parserContext, builder);
	}
	 private static Map<QName, List<Element>> getChildElements(Element parent) {
	        Map<QName, List<Element>> children = new HashMap<QName, List<Element>>();
	        NodeList childNodes = parent.getChildNodes();

	        for (int i = 0; i < childNodes.getLength(); i++) {
	            Node childNode = childNodes.item(i);
	            if (childNode.getNodeType() == Node.ELEMENT_NODE) {
	                Element e = (Element) childNode;
	                QName qname = new QName(e.getNamespaceURI(), e.getLocalName(), e.getPrefix());
	                List<Element> elements = children.get(qname);
	                if (elements == null) {
	                    elements = new ArrayList<Element>();
	                    children.put(qname, elements);
	                }
	                elements.add(e);
	            }
	        }
	        return children;
	    }
	protected void doParse(Element element, BeanDefinitionBuilder bean) {  
		org.w3c.dom.Document document=	 element.getOwnerDocument();
//		document.setPrefix(null);
 	      DOMImplementationLS domImplLS = (DOMImplementationLS)document.getImplementation();
	     
 	      LSSerializer serializer = domImplLS.createLSSerializer();
	      DOMConfiguration domConfig = serializer.getDomConfig();
	      domConfig.setParameter("namespaces",Boolean.FALSE);
	      domConfig.setParameter("namespace-declarations", Boolean.FALSE);
	      String str = serializer.writeToString(element);
		str=str.replaceAll(element.getPrefix()+":", "");
		
//	        WorkFlowData.initglobal(str);
	    }  
	 
}
