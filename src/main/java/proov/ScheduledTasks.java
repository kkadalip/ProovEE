package proov;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import proov.interfaces.DbI;

@Slf4j
@Component
public class ScheduledTasks {
	private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

	private final DbI dbI;

	@Autowired
	public ScheduledTasks(DbI dbI) {
		this.dbI = dbI;
	}

	@Scheduled(fixedRate = 60000) // Every 1 minutes (1 minutes * 60000 ms in one minute)
	public void updateObservations() {
		log.info("updateObservations :: Fixed Rate Task :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));
		dbI.updateObservations();
	}

	@Scheduled(fixedRate = 3600000) // Every 1 hour (60 minutes * 60000 ms in one minute)
	public void updateObservationsForStatistics() {
		log.info("updateObservations :: Fixed Rate Task :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));
		dbI.updateObservations(getHumanReadableTimestamp() + ".xml");
	}

	private String getHumanReadableTimestamp() {
		return new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	}
}