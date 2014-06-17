package com.datical.integration.bamboo;

import java.util.Arrays;

import com.atlassian.bamboo.build.logger.BuildLogger;
import com.atlassian.bamboo.process.ExternalProcessBuilder;
import com.atlassian.bamboo.process.ProcessService;
import com.atlassian.bamboo.task.TaskContext;
import com.atlassian.bamboo.task.TaskException;
import com.atlassian.bamboo.task.TaskResult;
import com.atlassian.bamboo.task.TaskResultBuilder;
import com.atlassian.bamboo.task.TaskType;
import com.atlassian.utils.process.ExternalProcess;

import org.jetbrains.annotations.NotNull;

public class ExampleTask implements TaskType {

	private final ProcessService processService;

	public ExampleTask(final ProcessService processService) {
		this.processService = processService;
	}

	@NotNull
	@java.lang.Override
	public TaskResult execute(@NotNull final TaskContext taskContext)
			throws TaskException {
		
		
		final BuildLogger buildLogger = taskContext.getBuildLogger();

		final String hammer = taskContext.getConfigurationMap().get("hammer");
		final String drivers = taskContext.getConfigurationMap().get("drivers");
		final String projectDir = taskContext.getConfigurationMap().get("projectDir");
		final String command = "checkdrivers";

		buildLogger.addBuildLogEntry("Location of Datical DB: " + hammer);

		TaskResultBuilder builder = TaskResultBuilder.create(taskContext);
		
		ExternalProcess process = processService.createProcess(taskContext,
				new ExternalProcessBuilder().command(Arrays.asList(hammer, "-drivers", drivers, "--project", projectDir, command))
						.workingDirectory(taskContext.getWorkingDirectory()));

		
		process.execute();
        
        return builder.checkReturnCode(process, 0).build();
		
		//return TaskResultBuilder.create(taskContext).success().build();
	}
}
