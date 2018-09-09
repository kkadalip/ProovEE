package proov;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import proov.interfaces.DownloadI;

@Slf4j
@Component
public class ScheduledTasks {
	private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

	private final DownloadI downloadI;

	@Autowired
	public ScheduledTasks(DownloadI downloadI) {
		this.downloadI = downloadI;
	}

	@Scheduled(fixedRate = 300000) // Every 5 minutes (5 minutes * 60000 ms in one minute)
	public void updateObservations() {
		log.info("updateObservations :: Fixed Rate Task :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));
		downloadI.downloadObservationsDTO();
	}

	@Scheduled(fixedRate = 3600000) // Every 1 hour (60 minutes * 60000 ms in one minute)
	public void updateObservationsForStatistics() {
		log.info("updateObservations :: Fixed Rate Task :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));
		downloadI.downloadObservationsDTO(getHumanReadableTimestamp() + ".xml");
	}

	private String getHumanReadableTimestamp() {
		return new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	}
}