package ca.gc.aafc.seqdb.api;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(
    classes = SeqdbApiLauncher.class,
    webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT,
    properties = "server.port=8080"
)
public abstract class BaseHttpIntegrationTest extends BaseIntegrationTest { }