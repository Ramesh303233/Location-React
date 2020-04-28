package com.bharath.location.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bharath.location.dao.LocationDao;
import com.bharath.location.entities.City;
import com.bharath.location.entities.Location;

@Transactional
@Repository
public class LocationDaoImpl implements LocationDao {

	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public LocationDaoImpl(DataSource dataSource) {
		System.out.println("Constructor called");
		this.dataSource = dataSource;
	}

	@Override
	public boolean saveQuery(Location loc) {

		String query = "INSERT INTO location (code,type,name) VALUES (?,?,?)";
		/**
		 * Define the connection and preparedStatement parameters
		 */
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			/**
			 * Open the connection
			 */
			connection = dataSource.getConnection();
			/**
			 * Prepare the statement
			 */
			preparedStatement = connection.prepareStatement(query);
			/**
			 * Bind the parameters to the PreparedStatement
			 */
			preparedStatement.setString(1, "A");
			preparedStatement.setString(2, "N");
			preparedStatement.setString(3, "B");
			/**
			 * Execute the statement
			 */
			preparedStatement.execute();
		} catch (SQLException e) {
			/**
			 * Handle any exception
			 */
			e.printStackTrace();
		} finally {
			try {
				/**
				 * Close the preparedStatement
				 */
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				/**
				 * Close the connection
				 */
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				/**
				 * Handle any exception
				 */
				e.printStackTrace();
			}
		}

		return true;
	}

	@Override
	public List<City> getCityDetails(String id) {
		String query = "select code,type,name from location where id =?";

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<City> resList = new ArrayList<>();
		try {

			connection = dataSource.getConnection();

			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, id);

			resultSet = preparedStatement.executeQuery();  

			System.out.println("resultSet test  "+resultSet);
			
			if (resultSet.next()) {
				City locRes = new City();
				locRes.setCode(resultSet.getString("CODE"));
				locRes.setName(resultSet.getString("name"));
				locRes.setType(resultSet.getString("type"));

				System.out.println("resultset " + resultSet);
				resList.add(locRes);
			}
		} catch (SQLException e) {
			/**
			 * Handle any exception
			 */
			e.printStackTrace();
		} finally {
			try {
				/**
				 * Close the preparedStatement
				 */
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				/**
				 * Close the connection
				 */
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				/**
				 * Handle any exception
				 */
				e.printStackTrace();
			}
		}

		return resList;
	}

}
