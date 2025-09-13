# Maven Publish

## Commands

```shell
./mvnw release:prepare -s /Users/adesilva/Development/projects/java/my-utils/.m2/settings.xml -B -DscmCommentPrefix="JIRA:MAINT-00000:"
./mvnw release:perform -s /Users/adesilva/Development/projects/java/my-utils/.m2/settings.xml
```