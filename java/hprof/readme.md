javac *.java

jar cfm agent.jar MANIFEST.MF Agent.class

java -javaagent:agent.jar -agentlib:hprof HprofTest

java -javaagent:agent.jar -agentlib:hprof=format=b HprofTest

