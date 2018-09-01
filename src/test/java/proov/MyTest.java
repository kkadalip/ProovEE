package proov;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Test;

public class MyTest {
	@Test
	public void name() throws Exception {
		//ByteArrayOutputStream out = new ByteArrayOutputStream();
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		HelloWorld.print(new PrintStream(out));
		String s = out.toString();
		Assert.assertEquals("Hello", s);
	}

}
