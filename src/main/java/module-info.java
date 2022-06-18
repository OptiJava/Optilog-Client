module com.optilog {
    exports com.optilog.log;
    exports com.optilog.annotation;
    exports com.optilog.util;
    exports com.optilog.log.jdbc;
    exports com.optilog.setting;

    requires java.sql;
    requires com.google.gson;
    requires com.fasterxml.jackson.dataformat.xml;
    requires org.yaml.snakeyaml;
}