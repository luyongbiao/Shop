package org.bqj.shopping.dao.impl;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.bqj.shopping.dao.BaseDAO;
import org.bqj.shopping.db.DB;

public class BaseDAOImpl<T> implements BaseDAO<T> {
	
	private  String tableName;
	private Class<T> tclass;
	private Method[] setMethods; 
	private Method[] getMethods; 
	private String[] typeNames; 
	private Field[] fields; 
	
	public BaseDAOImpl() {
		Class<?> clazz = this.getClass(); 
		Type gtype = clazz.getGenericSuperclass(); 
		ParameterizedType ptype = (ParameterizedType)gtype;
		@SuppressWarnings("unchecked")
		Class<T> classType = (Class<T>) 
							ptype.getActualTypeArguments()[0]; 
		this.tclass = classType;
		this.tableName = classType.getSimpleName().toLowerCase();

		fields = tclass.getDeclaredFields();
		typeNames = new String[fields.length];
		this.setMethods = new Method[fields.length];
		this.getMethods = new Method[fields.length];
		int i = 0;
		for(Field field: fields) {
			Type type = field.getGenericType();
			typeNames[i] = type.getTypeName()
					.substring(type.getTypeName().lastIndexOf(".") + 1);
			PropertyDescriptor pd = null;
			try {
				pd = new 
						PropertyDescriptor(field.getName(), tclass);
			} catch (IntrospectionException e) {

				e.printStackTrace();
			}

			setMethods[i] = pd.getWriteMethod(); //得到set方法

			
			setMethods[i] = pd.getWriteMethod();
//>>>>>>> branch 'master' of https://github.com/luyongbiao/Shop.git
			getMethods[i] = pd.getReadMethod();
			i++;
		}
	}
	
	@Override
	public T loadById(Integer id)  {
		Connection conn = DB.getConn();
		Statement stmt = DB.createStatement(conn);
		String sql = "select * from " + tableName + " where " + tableName + 
				"Id=" + id;
		ResultSet rs = DB.executeQuery(stmt, sql);
		T t = null;
		
		try {
			t = tclass.newInstance();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}
		
		try {
			while (rs.next()) {
				for (int i = 0; i < getMethods.length; i++) {		
					String methodName = "get" + typeNames[i].substring
							(0,1).toUpperCase() + typeNames[i].substring(1);
					Method method = null;
					if (!typeNames[i].equals("Integer")) {
						method = rs.getClass().getMethod(methodName, int.class);
					} else {
						method = rs.getClass().getMethod("getInt", int.class);
					}
					setMethods[i].invoke(t, method.invoke(rs,i+1));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			
		} catch (NoSuchMethodException e) {
			e.printStackTrace();

		} catch (SecurityException e) {
			e.printStackTrace();
		}
		
		DB.close(rs);
		DB.close(stmt);
		DB.close(conn);
		return t;
	}

	@Override
	public List<T> findAll() {
		List<T> list = new ArrayList<>();
		Connection conn = DB.getConn();
		Statement stmt = DB.createStatement(conn);
		String sql = "select * from " + tableName;
		ResultSet rs = DB.executeQuery(stmt, sql);
		try {
			while (rs.next()) {
				T t = null;
				try {
					t = tclass.newInstance();
				} catch (InstantiationException e1) {
					e1.printStackTrace();
				} catch (IllegalAccessException e1) {
					e1.printStackTrace();
				}
				for (int i = 0; i < getMethods.length; i++) {
					String methodName = "get" + typeNames[i].substring
							(0,1).toUpperCase() + typeNames[i].substring(1);
					Method method = null;
					if (!typeNames[i].equals("Integer")) {
						method = rs.getClass().getMethod(methodName, int.class);
					} else {
						method = rs.getClass().getMethod("getInt", int.class);
					}
					setMethods[i].invoke(t, method.invoke(rs,i+1));
				}
				list.add(t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
			
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		DB.close(rs);
		DB.close(stmt);
		DB.close(conn);
		return list;
	}

	@Override
	public void save(T t) {
		Connection conn = DB.getConn();
		String sql = "insert into " + this.tableName + " values (null";
		for(int i = 1; i < typeNames.length; i++) {
			sql += ",?";
		}
		sql += ")";
		
		PreparedStatement pstmt = DB.preparedStatement(conn, sql);
		for (int i = 1; i < getMethods.length; i++) {
			String methodName = "set" + typeNames[i].substring
					(0,1).toUpperCase() + typeNames[i].substring(1);
			Method method = null;
			try {
				if (typeNames[i].equals("Double")) {
						method = pstmt.getClass().getMethod(methodName, int.class, double.class);
				} else if (typeNames[i].equals("Long")) {
					method = pstmt.getClass().getMethod(methodName, int.class, long.class);
				} else if (typeNames[i].equals("Byte")) {
					method = pstmt.getClass().getMethod(methodName, int.class, byte.class);
				} else if (typeNames[i].equals("Short")) {
					method = pstmt.getClass().getMethod(methodName, int.class, short.class);
				} else if (typeNames[i].equals("Float")) {
					method = pstmt.getClass().getMethod(methodName, int.class, float.class);
				} else if (typeNames[i].equals("Boolean")) {
					method = pstmt.getClass().getMethod(methodName, int.class, boolean.class);
				}
			    else  if (!typeNames[i].equals("Integer")) {
					method = pstmt.getClass().getMethod(methodName, int.class, Class.forName(fields[i].getGenericType().getTypeName()));
				}  else if (typeNames[i].equals("Integer"))
					method = pstmt.getClass().getMethod("setInt", int.class, int.class);
				method.invoke(pstmt, i, getMethods[i].invoke(t));
			} catch (IllegalAccessException e) {

				e.printStackTrace();
			} catch (IllegalArgumentException e) {

				e.printStackTrace();
			} catch (InvocationTargetException e) {

				e.printStackTrace();
			} catch (NoSuchMethodException e) {

				e.printStackTrace();
			} catch (SecurityException e) {
				
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}
		}
		DB.executeUpdate(pstmt);
		DB.close(pstmt);
		DB.close(conn);
	}

	@Override
	public void removeOne(Integer id) {
		Connection conn = DB.getConn();
		String sql = "delete from " + this.tableName + " where " + fields[0].getName() + "=" + id;
		PreparedStatement pstmt = DB.preparedStatement(conn, sql);
		DB.executeUpdate(pstmt);
		DB.close(pstmt);
		DB.close(conn);
	}

	@Override
	public void removeAll() {
		Connection conn = DB.getConn();
		String sql = "delete from " + this.tableName;
		PreparedStatement pstmt = DB.preparedStatement(conn, sql);
		DB.executeUpdate(pstmt);
		DB.close(pstmt);
		DB.close(conn);
	}

	@Override
	public void modify(T t) {
		Connection conn = DB.getConn();
		StringBuffer sql = new StringBuffer("update " + this.tableName + " set ");
		try {
			for (int i = 1; i < getMethods.length; i++) {
			if(getMethods[i].invoke(t) != null) {
				sql.append(fields[i].getName().substring(0,1).toLowerCase() + fields[i].getName().substring(1) + "='" +  getMethods[i].invoke(t)+"', "); 
			}
		}
		if (sql.toString().contains(", ")) {
			sql.delete(sql.lastIndexOf(", "), sql.length() - 1);
		}
		sql.append(" where " + fields[0].getName() + "=" + getMethods[0].invoke(t));
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		Statement stmt = DB.createStatement(conn);
		DB.executeUpdate(stmt, sql.toString());
		System.out.println(sql);
		DB.close(stmt);
		DB.close(conn);
	}

	@Override
	public int findCount() {
		Connection conn = DB.getConn();
		String sql = "select count(*) from " + this.tableName;
		PreparedStatement pstmt = DB.preparedStatement(conn, sql);
		ResultSet rs = DB.executeQuery(pstmt);
		int count = 0;
		try {
			rs.next();
			count = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DB.close(rs);
		DB.close(pstmt);
		DB.close(conn);
		return count;
	}

	@Override
	public Set<T> find(int begin, int pageSize) {
		String sql = "select * from " + this.tableName + 
								" limit " + begin + "," + pageSize;
		System.out.println(sql);
		Connection conn = DB.getConn();
		Statement stmt = DB.createStatement(conn);
		ResultSet rs = DB.executeQuery(stmt, sql);
		Set<T> list  = new HashSet<>();
		try {
			while (rs.next()) {
				T t = tclass.newInstance();
				for(int i = 0; i < typeNames.length; i++) {
					String methodName = "get" + typeNames[i].substring
							(0,1).toUpperCase() + typeNames[i].substring(1);
					Method method = null;
					if (!typeNames[i].equals("Integer")) {
						method = rs.getClass().getMethod(methodName, int.class);
					} else {
						method = rs.getClass().getMethod("getInt", int.class);
					}
					setMethods[i].invoke(t, method.invoke(rs, (i+1)));
				}
				list.add(t);
			}
		} catch (InstantiationException e) {
			
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			
			e.printStackTrace();
		} catch (SecurityException e) {
			
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		DB.close(rs);
		DB.close(stmt);
		DB.close(conn);
		return list;
	}
}
