package com.bharath.location.daoTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bharath.location.dao.LocationDao;
import com.bharath.location.entities.City;
import com.bharath.location.entities.Location;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LocationDaoImplTest {

	@Mock
	DataSource mockDataSource;
	@Mock
	Connection mockConn;
	@Mock
	PreparedStatement mockPreparedStmnt;
	@Mock
	ResultSet mockResultSet;

	@Mock
	LocationDao lDao;
	int userId = 100;

	City c;

	@BeforeClass
	public static void setUpClass() throws Exception {

	}

	@Before
	public void setUp() throws SQLException {
		when(mockDataSource.getConnection()).thenReturn(mockConn);
		when(mockDataSource.getConnection(Mockito.anyString(), Mockito.anyString())).thenReturn(mockConn);
		doNothing().when(mockConn).commit();
		when(mockConn.prepareStatement(Mockito.anyString(), Mockito.anyInt())).thenReturn(mockPreparedStmnt);
		doNothing().when(mockPreparedStmnt).setString(Mockito.anyInt(), Mockito.anyString());
		when(mockPreparedStmnt.execute()).thenReturn(Boolean.TRUE);
		when(mockPreparedStmnt.getGeneratedKeys()).thenReturn(mockResultSet);
		when(mockResultSet.next()).thenReturn(Boolean.TRUE, Boolean.FALSE);
		// when(mockResultSet.getInt(Fields.GENERATED_KEYS)).thenReturn(userId);
	}

	@Test
	public void testMethod() throws SQLException {
		// LocationDao lDao = new LocationDaoImpl(mockDataSource);
		City l = new City();
		Location loc = new Location();
		String id = "10";
		lDao.getCityDetails(id);
		// boolean result = mockDataSource.getConnection() != null;
		// Assert.assertTrue(result);
		// Mockito.verify(mockConn, Mockito.times(1)).prepareStatement(
		// Mockito.anyString(), Mockito.anyInt());
		// verify(mockPreparedStmnt, times(6)).setString(anyInt(), anyString());

		// Mockito.when(mockConn.prepareStatement(Mockito.eq("INSERT INTO location
		// (code,type,name) VALUES (?,?,?)"))).thenReturn(mockPreparedStmnt);
		// Mockito.when(mockPreparedStmnt.executeUpdate()).thenReturn(1);

		// Mockito.verify(mockConn).prepareStatement(Mockito.eq("INSERT INTO location
		// (code,type,name) VALUES (?,?,?)"));
		// result = lDao.saveQuery(loc);
		// Assert.assertTrue(result);
		/*
		 * Mockito.verify(mockPreparedStmnt).setString(Mockito.eq(1),
		 * Mockito.eq("Test"));
		 * Mockito.verify(mockPreparedStmnt).setString(Mockito.eq(2),
		 * Mockito.eq("Test"));
		 * Mockito.verify(mockPreparedStmnt).setString(Mockito.eq(3),
		 * Mockito.eq("Test")); Mockito.verify(mockPreparedStmnt).executeUpdate();
		 */
		// LocationDaoImpl instance = new LocationDaoImpl(mockDataSource);
		// instance.getCityDetails(id);

		assertNotNull(mockDataSource);
		when(mockConn.prepareStatement(Mockito.anyString())).thenReturn(mockPreparedStmnt);
		when(mockDataSource.getConnection()).thenReturn(mockConn);

		c = new City();
		c.setId(1);
		c.setName("Ramesh");
		c.setType("T");

		when(mockResultSet.first()).thenReturn(true);
		when(mockResultSet.getInt(1)).thenReturn(1);
		when(mockResultSet.getString(2)).thenReturn(c.getName());
		when(mockResultSet.getString(3)).thenReturn(c.getType());
		when(mockPreparedStmnt.executeQuery()).thenReturn(mockResultSet);

	}

	@Test
	public void show() throws SQLException {
		String query = "select code,type,name from location where id =?";

		String id = "10";

		c = new City();
		c.setId(1);
		c.setName("Ramesh");
		c.setType("T");

		List<City> c2 = getData();
		mockPreparedStmnt.setString(1, "10");
		when(mockPreparedStmnt.executeQuery(query)).thenReturn(mockResultSet);
		when(mockResultSet.first()).thenReturn(true);
		when(mockResultSet.getInt(1)).thenReturn(1);
		when(mockResultSet.getString(2)).thenReturn(c.getName());
		when(mockResultSet.getString(3)).thenReturn(c.getType());
		when(mockPreparedStmnt.executeQuery()).thenReturn(mockResultSet);

		System.out.println("Get data=== " + getData());

		System.out.println("c rsult " + c);
		System.out.println("mockResultSet =" + mockResultSet);
		System.out.println("mockResultSet.getString(2) " + mockResultSet.getString(2));
		assertEquals("Ramesh", mockResultSet.getString(2));

		when(lDao.getCityDetails(id)).thenReturn(c2);
		List<City> c = lDao.getCityDetails(id);

		System.out.println("final result " + c);

		assertEquals(c2.get(0).getName(), c.get(0).getName());
		assertEquals(c2.get(0).getType(), c.get(0).getType());

	}
	
	
	@SuppressWarnings("deprecation")
	@Test
	public void testShow() throws SQLException {
		String id="10";
		List<Object[]> listObj =  getTestData();
		List<City> cList = getData();
		String query = "select code,type,name from location where id =?";
		when(mockConn.prepareStatement(query)).thenReturn(mockPreparedStmnt);
		when(mockPreparedStmnt.executeQuery(query)).thenReturn(mockResultSet);		
      //  when(mockPreparedStmnt.setString(1, id)).thenReturn(mockResultSet);	
		when(mockResultSet.next()).thenReturn(true);
		when(mockResultSet.getString("name")).thenReturn("Test1");
		List<City> cListRes = lDao.getCityDetails(id);
		System.out.println("cListRes.get(0).getName() = "+cListRes);
	//Assert.assertTrue(cListRes.get(0).getName().equalsIgnoreCase(mockResultSet.getString("name")));
	}


	private List<Object[]> getTestData(){
		
			
		List<Object[]> list = new ArrayList<>();
		
		Object[] obj1 = new Object[] {"CUS","TST","MEM"};
		Object[] obj2 = new Object[] {"CUS1","TST1","MEM1"};		
		list.add(obj1);
		list.add(obj2);
		
		return list;
		
	}
	
	
	public List<City> getData() {
		City c1 = new City();
		c1.setName("Test1");
		c1.setType("Y1");

		List<City> cList = new ArrayList();
		cList.add(c1);

		return cList;

	}

}
