package com.kdy.s3.notice;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kdy.s3.MyTestCase;
import com.kdy.s3.notice.NoticeDAO;
import com.kdy.s3.notice.NoticeDTO;
import com.kdy.s3.util.Pager;



public class NoticeDAOTest extends MyTestCase {
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	@AfterClass
	public static void after() {
		System.out.println("after class");
	}
	
	@BeforeClass
	public static void before() {
		System.out.println("before class");
	}
	
	@After
	public void afterTest() {
		System.out.println("After Method");
	}
	
	@Before
	public void beforeTest() {
		System.out.println("Before Method");
	}
	
//	@Test
//	public void noticeCountTest() throws Exception {
//		int result = noticeDAO.noticeCount(110);
//		assertEquals(110, result);
//		
//	}
	
	//@Test
	public void noticeListTest() throws Exception {
		Pager pager = new Pager();
		pager.setStartRow(1);
		pager.setLastRow(10);
		List<NoticeDTO> ar = noticeDAO.noticeList(pager);
		assertEquals(10, ar.size());
	}
	
	//@Test
	public void noticeDeleteTest() throws Exception {
		System.out.println("Delete");
		NoticeDTO noticeDTO = new NoticeDTO();
		int result = noticeDAO.noticeDelete(215);
		assertEquals(0, result);
		
	}
	
	//@Test
	public void noticeInsertTest() throws Exception {

		for(int i=0;i<100;i++) {
			NoticeDTO noticeDTO = new NoticeDTO();
			noticeDTO.setTitle("title"+i);
			noticeDTO.setContents("Contents"+i);
			noticeDTO.setWriter("Test Writer"+i);
			int result = noticeDAO.noticeWrite(noticeDTO);
			
			if(i%10==0) {
				Thread.sleep(1000);
			}
			
		}
		
	}
	
	//@Test
	public void noticeSelectTest() throws Exception {
		System.out.println("Select");
		NoticeDTO noticeDTO = noticeDAO.noticeSelect(250);
		
		// 단정문
		assertNotNull(noticeDTO);
		
		
	}

}
