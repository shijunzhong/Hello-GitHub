package com.paul.application;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.util.Calendar;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import tk.mybatis.spring.annotation.MapperScan;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@ComponentScan("com.paul.**")
@MapperScan(basePackages = "com.paul.dao")
public class NoobApplication {

	public static void main(String[] args) throws ParseException {
		SpringApplication.run(NoobApplication.class, args);
		
/*		
		// try...catch...finally... 返回测试
		System.out.println(get());

*/
		
/*
		// String对象测试
		String s1 = "Programming";
        String s2 = new String("Programming");
        String s3 = "Program" + "ming";
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s1 == s1.intern());
*/
		
/*
		// 正则表达式测试
        final String phone = "18196581661";
		final String reg = "^((13[0-9])|(15[0-9])|(18[0-9])|(17[0-9])|(14[0-9]))\\d{8}$";
        final Pattern p = Pattern.compile(reg);
        System.out.println(phone.matches(reg));
        System.out.println(p.matcher(phone.trim()).matches());
        // 不是有效的手机号码
        if (!p.matcher(phone.trim()).matches()) {
            return ;
        }
*/

/*
		// 深克隆测试
		User u = new User();
		u.setAge(1);
		u.setName("1");
		Person p1 = new Person("p1", u);
		Person p2 = (Person) p1.deepClone();
		p2.getUser().setAge(2);
		p2.getUser().setName("2");
		System.out.println(p1.getUser().getAge() + "=================" +  p1.getUser().getName());
*/	
	
/*
		// java8日期类测试
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		System.out.println(LocalDate.now().format(dtf));
*/
		
		Calendar cal = Calendar.getInstance();
		System.out.println(cal.get(Calendar.DAY_OF_WEEK));

		
/*
		// 文件流复制测试
		long begin = System.currentTimeMillis();
		// FileUtil.fileCopy("F://TestSource.rar", "F://TestTarget.rar"); // 5
		FileUtil.fileCopyNIO("F://TestSource.rar", "F://TestTargetNIO.rar"); // 10
		long end = System.currentTimeMillis();
		System.out.println("time cost: " + (end - begin));
*/
		
/*
		// 字符串出现在文件中次数测试
		int count = FileUtil.getStringOccur("F://TestOccur.txt", "123");
		System.out.println(count);
*/
	
/*
		// 递归出文件夹下的目录
		File f = new File("F://var");
		File[] files = f.listFiles();
		for (File file : files) {
			System.out.println(file.getName() + "\n");
			
			if(file.isDirectory()) {
				loopDirectory(file);
			} 
		}
*/
		
/*
		// 反射测试
		User u = new User();
		u.setName("nier");
		Object value = getValue(u, "name");
		System.out.println(value);
*/
	
	}
	
	private static void loopDirectory(File file) {
		File[] files = file.listFiles();
		for (File _file : files) {
			if(_file.isDirectory()) {
				System.out.println(_file.getName());
				loopDirectory(_file);
			} 
		}
	}

	private static Object getValue(Object source, String fieldName) {
		Class<? extends Object> clazz = source.getClass();
		try {
			Field f = clazz.getDeclaredField(fieldName);
			Method m = clazz.getDeclaredMethod("toString");
			f.setAccessible(true);
			f.set(source, "auto");
			// return f.get(source);
			return m.invoke(source);
		} catch (Exception e) {
			throw new RuntimeException("cant't find value");
		}
	}
	
	private static int get() {
		int x = 0;
		
		try {
			x += 1;
			return 5;
		} catch(Exception e) {
			x -= 1;
		} finally {
			x = -1;
			System.out.println(x);
		}

		System.out.println(x);
		return x;
	}

	public static Date getBeginDayOfWeek() throws ParseException {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int dayofweek = cal.get(Calendar.DAY_OF_WEEK);
		cal.add(Calendar.DATE, 1 - dayofweek);
		Date date2 = sdf.parse(sdf.format(cal.getTime()));
		return date2;
	}
	
	public static int getDaysOfMonth(Date date) {  
        Calendar calendar = Calendar.getInstance();  
        calendar.setTime(date);  
        return calendar.getActualMaximum(Calendar.DAY_OF_WEEK);  
    } 
}
