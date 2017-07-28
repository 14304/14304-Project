package com.example.service;

import com.example.domain.Department;
import com.example.persistence.DepartmentMapper;
import com.example.persistence.UserMapper;
import com.example.security.DepartmentStatus;
import javafx.beans.binding.When;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.powermock.api.mockito.PowerMockito;

import java.time.ZonedDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


/**
 * Created by silence on 2017/7/25.
 */
public class DepartmentServiceTest {
   private DepartmentMapper departmentMapper;
    private UserMapper userMapper;
    @Before
    public void setUp() throws Exception {
        departmentMapper = PowerMockito.mock( DepartmentMapper.class );
        userMapper = PowerMockito.mock( UserMapper.class );
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getDepartments() throws Exception {
    }

    @Test
    public void createDepartment() throws Exception {
        // 1.准备数据
        Department department = new Department();
        department.setId( 6L );
        department.setName( "test_name123" );
        department.setCode( "test" );
        department.setStatus( DepartmentStatus.parse( 0 ) );
        department.setCreateDate( ZonedDateTime.now() );
        // 2.Mock 方法行为
            // 参数捕获器
        ArgumentCaptor<Department> departmentArgumentCaptor = ArgumentCaptor.forClass( Department.class );
            //  当departmentMapper调用insert方法时参数会保存到departmentArgumentCaptor中
        PowerMockito.when( departmentMapper.insert( departmentArgumentCaptor.capture() ) ).thenReturn( 1 );
        // 3.方法调用
        Department actual = new DepartmentService( departmentMapper,userMapper ).createDepartment( department );
        // 4.verify 结果
            // 拿取调用时的参数
        assertThat( departmentArgumentCaptor.getValue().getName() ).isEqualTo("test_name123");
            // 拿取返回结果的参数
        assertThat( actual.getId() ).isEqualTo( 6L );
            // 只调用一次
        verify( departmentMapper,times(1) ).insert( departmentArgumentCaptor.capture() );
    }

}