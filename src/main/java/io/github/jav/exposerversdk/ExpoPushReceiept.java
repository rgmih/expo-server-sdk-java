package io.github.jav.exposerversdk;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import org.apache.commons.lang3.builder.EqualsBuilder;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties({"_debug"})
public class ExpoPushReceiept {

    public String id = null;
    private Status status = null;
    private String message = null;
    private Details details = null;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Details getDetails() {
        return details;
    }

    public void setDetails(Details details) {
        this.details = details;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }



    @Override
    public boolean equals(Object _o) {
        if (_o == null)
            return false;

        if (_o == this)
            return true;

        if (_o.getClass() != getClass())
            return false;

        ExpoPushReceiept o = (ExpoPushReceiept) _o;
        return new EqualsBuilder().
                append(status, o.status).
                append(id, o.id).
                append(message, o.message).
                append(details, o.details).
                isEquals();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, getStatus(), getMessage(), getDetails(), getAdditionalProperties());
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties({"apns", "fcm"})
    public static class Details {

        private String error;
        private Integer sentAt;
        @JsonIgnore
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        public String getError() {
            return error;
        }

        public Details setError(String error) {
            this.error = error;
            return this;
        }

        public Integer getSentAt() {
            return sentAt;
        }

        public void setSentAt(Integer sentAt) {
            this.sentAt = sentAt;
        }

        @JsonAnyGetter
        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        @JsonAnySetter
        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Details)) return false;
            Details details = (Details) o;
            return Objects.equals(getError(), details.getError()) &&
                    Objects.equals(getSentAt(), details.getSentAt()) &&
                    Objects.equals(getAdditionalProperties(), details.getAdditionalProperties());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getError(), getSentAt(), getAdditionalProperties());
        }
    }
}