package com.datical.integration.bamboo;

import org.jetbrains.annotations.NotNull;

import com.atlassian.bamboo.build.logger.BuildLogger;
import com.atlassian.bamboo.task.TaskContext;
import com.atlassian.bamboo.task.TaskException;
import com.atlassian.bamboo.task.TaskResult;
import com.atlassian.bamboo.task.TaskResultBuilder;
import com.atlassian.bamboo.task.TaskType;

public class DaticalTask implements TaskType {

	@Override
	@NotNull
	public TaskResult execute(@NotNull TaskContext taskContext) throws TaskException {

		final TaskResultBuilder builder = TaskResultBuilder.create(taskContext).failed(); // Initially set to Failed.

		final BuildLogger buildLogger = taskContext.getBuildLogger();

        final String say = taskContext.getConfigurationMap().get("say");
 
        buildLogger.addBuildLogEntry(say);		

		builder.success();

		final TaskResult result = builder.build();

		return result;

	}

}
