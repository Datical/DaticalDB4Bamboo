package com.datical.integration.bamboo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.atlassian.bamboo.build.logger.BuildLogger;
import com.atlassian.bamboo.process.ExternalProcessBuilder;
import com.atlassian.bamboo.process.ProcessService;
import com.atlassian.bamboo.task.TaskContext;
import com.atlassian.bamboo.task.TaskException;
import com.atlassian.bamboo.task.TaskResult;
import com.atlassian.bamboo.task.TaskResultBuilder;
import com.atlassian.bamboo.task.TaskType;
import com.atlassian.utils.process.ExternalProcess;
import com.google.common.collect.ImmutableList;

import org.apache.commons.lang.ArrayUtils;
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
		final String command = taskContext.getConfigurationMap().get("command");
		final String exportSQL = taskContext.getConfigurationMap().get("exportSQL");
		final String exportRollbackSQL = taskContext.getConfigurationMap().get("exportRollbackSQL");
		
		buildLogger.addBuildLogEntry("Export SQL: " + exportSQL);
		buildLogger.addBuildLogEntry("Export Rollback SQL: " + exportRollbackSQL);
		
		// TODO: test sql and add the following to command array
		//--genSQL --genRollbackSQL
		
		//command
		final Map<String, String> commandMap = new HashMap<String, String>();
		commandMap.put("Change Log Sync", "changelogSync");
		commandMap.put("Check Drivers", "checkdrivers");
		commandMap.put("Clear Check Sums", "clearCheckSums");
		commandMap.put("List all Datbases in a Project", "dbshow");
		commandMap.put("Deploy", "deploy");
		commandMap.put("Deploy with Auto Rollback", "deploy-autoRollback");
		commandMap.put("Compare Schemas (Report)", "diff");
		commandMap.put("Compare Schemas (Change Log)", "diffChangelog");
		commandMap.put("Forecast", "forecast");
		commandMap.put("Show History", "history");
		commandMap.put("Install a License File", "installLicense");
		commandMap.put("Rollback", "rollback");
		commandMap.put("Display Summary Schema Info", "schemaStats");
		commandMap.put("Set Property", "set");
		commandMap.put("Show Property", "show");
		commandMap.put("Snapshot", "snapshot");
		commandMap.put("Show Status", "status");
		commandMap.put("Show Status (Detailed)", "statusDetails");
		commandMap.put("Create New Datical DB Project", "newProj");
		commandMap.put("Create New Database Definition", "newDBDef");
		buildLogger.addBuildLogEntry("command: " + command);
		buildLogger.addBuildLogEntry("command lookup: " + commandMap.get(command));
		
		
		
		final String args = taskContext.getConfigurationMap().get("args");
		String[] myArgs = args.split(" ");

		buildLogger.addBuildLogEntry("Location of Datical DB: " + hammer);

		TaskResultBuilder builder = TaskResultBuilder.create(taskContext);
		
		ExternalProcess process = processService.createProcess(taskContext,
				new ExternalProcessBuilder().command(Arrays.asList(hammer, "-drivers", drivers, "--project", projectDir, command, args))
						.workingDirectory(taskContext.getWorkingDirectory()));

		
		process.execute();
        
        return builder.checkReturnCode(process, 0).build();
		
		//return TaskResultBuilder.create(taskContext).success().build();
	}
}
