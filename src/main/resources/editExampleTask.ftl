
[@ww.textfield labelKey="daticaldb.hammer" name="hammer" required="true"/]
[@ww.textfield labelKey="daticaldb.drivers" name="drivers" required="true"/]
[@ww.textfield labelKey="daticaldb.projectDir" name="projectDir" required="true"/]
[@ww.select labelKey="daticaldb.command" name="command" list="{
'Change Log Sync', 
'Check Drivers', 
'Clear Check Sums', 
'List all Databases in a Project',
'Deploy', 
'Deploy with Auto Rollback',
'Compare Schemas (Report', 
'Compare Schemas (Change Log',
'Forecast', 
'Show History',
'Install a License File', 
'Rollback', 
'Display Summary Schema Info',
'Set Property', 
'Show Property',
'Snapshot', 
'Show Status', 
'Show Status (Detailed)', 
'Create New Datical DB Project',
'Create New Database Definition'
}" emptyOption="false" /]
[@ww.textfield labelKey="daticaldb.args" name="args" required="false"/]
[@ww.checkbox labelKey="daticaldb.exportSQL" name="exportSQL" required="false" /]
[@ww.checkbox labelKey="daticaldb.exportRollbackSQL" name="exportRollbackSQL" required="false" /]