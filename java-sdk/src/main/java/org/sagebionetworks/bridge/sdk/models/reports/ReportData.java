package org.sagebionetworks.bridge.sdk.models.reports;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.joda.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import org.sagebionetworks.bridge.sdk.models.upload.Upload;

import java.util.Objects;

import static org.sagebionetworks.bridge.sdk.utils.BridgeUtils.TO_STRING_STYLE;

/**
 * Record representing the data for a report entry (for a specific day). The SDK expects this data 
 * to be in JSON format so it is parsed here into an object model, though the REST API does not 
 * require this.
 */
public class ReportData {
    private final LocalDate date;
    private final JsonNode reportData;
    
    @JsonCreator
    public ReportData(@JsonProperty("date") LocalDate date, @JsonProperty("data") JsonNode reportData) {
        this.date = date;
        this.reportData = reportData;
    }
    
    public LocalDate getDate() {
        return date;
    }
    
    @JsonProperty("data")
    public JsonNode getReportData() {
        return reportData;
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, reportData);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        ReportData other = (ReportData) obj;
        return Objects.equals(date, other.date)
                && Objects.equals(reportData, other.reportData);
    }
    @Override
    public String toString() {
        return new ToStringBuilder(this, TO_STRING_STYLE).append("date", date)
                .append("reportData", reportData).build();
    }
}
