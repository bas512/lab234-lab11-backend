package camt.se234.lab11.service;

import camt.se234.lab11.dao.StudentDao;
import camt.se234.lab11.dao.StudentDaoImpl;
import camt.se234.lab11.entity.Student;
import camt.se234.lab11.exception.NoDataException;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StudentServiceImplTest {
    @Test
    public void testFindById(){
        StudentDaoImpl studentDao = new StudentDaoImpl();
        StudentServiceImpl studentService = new StudentServiceImpl();
        studentService.setStudentDao(studentDao);
        assertThat(studentService.findStudentById("123"), is(new Student("123", "A", "temp", 2.33)));
        assertThat(studentService.findStudentById("135"),is(new Student("135","B","dee",3.86)));
        assertThat(studentService.findStudentById("133"),is(new Student("133","C","omg",3.58)));
        assertThat(studentService.findStudentById("142"),is(new Student("142","D","lip",2.98)));

    }

    @Test
    public void getAverageGpa(){
        StudentDaoImpl studentDao = new StudentDaoImpl();
        StudentServiceImpl studentService = new StudentServiceImpl();
        studentService.setStudentDao(studentDao);
        assertThat(studentService.getAverageGpa(), is(closeTo(3.19, 0.01)));
    }

    @Test
    public void testWithMock(){
       // StudentDao studentDao = mock(StudentDao.class);
        List<Student> mockStudents = new ArrayList<>();
       // StudentServiceImpl studentService = new StudentServiceImpl();
       // studentService.setStudentDao(studentDao);
        mockStudents.add(new Student("123","A","temp",2.33));
        mockStudents.add(new Student("124","B","temp",2.33));
        mockStudents.add(new Student("223","C","temp",2.33));
        mockStudents.add(new Student("224","D","temp",2.33));

        mockStudents.add(new Student("135","B","dee",3.86));
        mockStudents.add(new Student("133","C","omg",3.58));
        mockStudents.add(new Student("142","D","lip",2.98));
        mockStudents.add(new Student("147","E","piece",3.23));

        when(studentDao.findAll()).thenReturn(mockStudents);
        assertThat(studentService.findStudentById("123"),is(new Student("123","A","temp",2.33)));
        assertThat(studentService.findStudentById("135"),is(new Student("135","B","dee",3.86)));
        assertThat(studentService.findStudentById("133"),is(new Student("133","C","omg",3.58)));
        assertThat(studentService.findStudentById("142"),is(new Student("142","D","lip",2.98)));
        assertThat(studentService.getAverageGpa(), is(closeTo(2.87, 0.01)));
    }

    @Test
    public void testFindByPartOfId(){
        //StudentDao studentDao = mock(StudentDao.class);
        List<Student> mockStudents = new ArrayList<>();
        //StudentServiceImpl studentService = new StudentServiceImpl();
        //studentService.setStudentDao(studentDao);
        mockStudents.add(new Student("123","A","temp",2.33));
        mockStudents.add(new Student("124","B","temp",2.33));
        mockStudents.add(new Student("223","C","temp",2.33));
        mockStudents.add(new Student("224","D","temp",2.33));
        when(studentDao.findAll()).thenReturn(mockStudents);
        assertThat(studentService.findStudentByPartOfId("22"),hasItem(new Student("223","C","temp",2.33)));
        assertThat(studentService.findStudentByPartOfId("22"),hasItems(new Student("223","C","temp",2.33),new Student("224","D","temp",2.33)));
        assertThat(studentService.findStudentByPartOfId("23"),hasItem(new Student("223","C","temp",2.33)));

    }
    StudentDao studentDao;
    StudentServiceImpl studentService;
    @Before
    public void setup(){
        studentDao = mock(StudentDao.class);
        studentService = new StudentServiceImpl();
        studentService.setStudentDao(studentDao);
    }
    @Test(expected = NoDataException.class)
    public void testNoDataException(){
        List<Student> mockStudents = new ArrayList<>();
        mockStudents.add(new Student("123","A","temp",2.33));

        when(studentDao.findAll()).thenReturn(mockStudents);
        assertThat(studentService.findStudentById("55"),nullValue());
    }
}
