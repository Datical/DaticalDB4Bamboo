[@ww.textfield labelKey="daticaldb.hammer" name="hammer" required="true"/]
[@ww.textfield labelKey="daticaldb.drivers" name="drivers" required="true"/]
[@ww.textfield labelKey="daticaldb.projectDir" name="projectDir" required="true"/]
[@ww.select labelKey="daticaldb.command" 
			id="command"
       		name="command"
       		list="commandList"
       		listKey="id"
       		listValue="command"
       		multiple="false"
       		size="1"
       		required="true"/]
[@ww.textfield labelKey="daticaldb.args" name="args" required="false"/]
[@ww.checkbox labelKey="daticaldb.exportSQL" name="exportSQL" toggle="false" required="false" /]
[@ww.checkbox labelKey="daticaldb.exportRollbackSQL" name="exportRollbackSQL" toggle="false" required="false" /]
                  
