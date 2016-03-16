package junit;

import java.io.File;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import util.parse.DomParseXml;

public class ParseXmlTest extends TestCase {
    
	private DomParseXml px;
	
	@Before
	protected void setUp() throws Exception {
		px = new DomParseXml();
		super.setUp();
	}
    
	@Test
	public void testParser() {
		assertNotNull(px.getFactorsHashMap(new File("element.xml")));
	}
	
	@After
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	

}
