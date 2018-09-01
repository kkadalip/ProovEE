package proov.interfaces;

import java.io.FileInputStream;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletContext;

//import model.Result;

public interface DownloadI {
	String fileNameDatePattern = "-yyyy-MM-dd";

	String getDownloadUrlByDate(LocalDate selectedDate);

	String getFileNameByDate(LocalDate selectedDate);

	Float fisToRate(FileInputStream fis, String inputCurrency);

	List<String> fisToCurrencies(FileInputStream fis);

	List<String> getCurrencies(ServletContext context, LocalDate selectedDate);
//	public Result getResult(ServletContext context, LocalDate selectedDate, String inputCurrency, String outputCurrency, Float inputMoneyAmount);
}