// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.provisioning.appconfiguration.generated;

import java.time.OffsetDateTime;
import com.azure.provisioning.BicepDictionary;
import java.util.Map;
import java.lang.String;
import com.azure.provisioning.BicepValue;
import com.azure.provisioning.primitives.Resource;
import com.azure.provisioning.tmp.ResourceType;

public class KeyValueResource extends Resource {

    private final BicepValue<Boolean> locked;
    private final BicepValue<String> contentType;
    private final BicepValue<String> resourceGroupName;
    private final BicepValue<String> configStoreName;
    private final BicepValue<String> value;
    private final BicepValue<String> key;
    private final BicepValue<OffsetDateTime> lastModified;
    private final BicepValue<String> etag;
    private final BicepValue<String> keyValueName;
    private final BicepValue<String> label;
    private final BicepDictionary<String> tags;

    public KeyValueResource(String identifierName) {
        this(identifierName, null);
    }

    public KeyValueResource(String identifierName, String resourceVersion) {
        super(identifierName, new ResourceType("Microsoft.AppConfiguration/configurationStores/keyValues"), resourceVersion);
        locked = BicepValue.defineProperty(this, "locked", new String[] { "temp", "locked" }, false, false, false, null);
        contentType = BicepValue.defineProperty(this, "contentType", new String[] { "temp", "contentType" }, false, false, false, null);
        resourceGroupName = BicepValue.defineProperty(this, "resourceGroupName", new String[] { "temp", "resourceGroupName" }, false, false, false, null);
        configStoreName = BicepValue.defineProperty(this, "configStoreName", new String[] { "temp", "configStoreName" }, false, false, false, null);
        value = BicepValue.defineProperty(this, "value", new String[] { "temp", "value" }, false, false, false, null);
        key = BicepValue.defineProperty(this, "key", new String[] { "temp", "key" }, false, false, false, null);
        lastModified = BicepValue.defineProperty(this, "lastModified", new String[] { "temp", "lastModified" }, false, false, false, null);
        etag = BicepValue.defineProperty(this, "etag", new String[] { "temp", "etag" }, false, false, false, null);
        keyValueName = BicepValue.defineProperty(this, "keyValueName", new String[] { "temp", "keyValueName" }, false, false, false, null);
        label = BicepValue.defineProperty(this, "label", new String[] { "temp", "label" }, false, false, false, null);
        tags = BicepDictionary.defineProperty(this, "tags", new String[] { "temp", "tags" }, false, false);
    }

    public BicepValue<Boolean> getLocked() {
        return this.locked;
    }

    public KeyValueResource setLocked(BicepValue<Boolean> locked) {
        this.locked.assign(locked);
        return this;
    }

    public KeyValueResource setLocked(Boolean locked) {
        return this.setLocked(BicepValue.from(locked));
    }

    public BicepValue<String> getContentType() {
        return this.contentType;
    }

    public KeyValueResource setContentType(BicepValue<String> contentType) {
        this.contentType.assign(contentType);
        return this;
    }

    public KeyValueResource setContentType(String contentType) {
        return this.setContentType(BicepValue.from(contentType));
    }

    public BicepValue<String> getResourceGroupName() {
        return this.resourceGroupName;
    }

    public KeyValueResource setResourceGroupName(BicepValue<String> resourceGroupName) {
        this.resourceGroupName.assign(resourceGroupName);
        return this;
    }

    public KeyValueResource setResourceGroupName(String resourceGroupName) {
        return this.setResourceGroupName(BicepValue.from(resourceGroupName));
    }

    public BicepValue<String> getConfigStoreName() {
        return this.configStoreName;
    }

    public KeyValueResource setConfigStoreName(BicepValue<String> configStoreName) {
        this.configStoreName.assign(configStoreName);
        return this;
    }

    public KeyValueResource setConfigStoreName(String configStoreName) {
        return this.setConfigStoreName(BicepValue.from(configStoreName));
    }

    public BicepValue<String> getValue() {
        return this.value;
    }

    public KeyValueResource setValue(BicepValue<String> value) {
        this.value.assign(value);
        return this;
    }

    public KeyValueResource setValue(String value) {
        return this.setValue(BicepValue.from(value));
    }

    public BicepValue<String> getKey() {
        return this.key;
    }

    public KeyValueResource setKey(BicepValue<String> key) {
        this.key.assign(key);
        return this;
    }

    public KeyValueResource setKey(String key) {
        return this.setKey(BicepValue.from(key));
    }

    public BicepValue<OffsetDateTime> getLastModified() {
        return this.lastModified;
    }

    public KeyValueResource setLastModified(BicepValue<OffsetDateTime> lastModified) {
        this.lastModified.assign(lastModified);
        return this;
    }

    public KeyValueResource setLastModified(OffsetDateTime lastModified) {
        return this.setLastModified(BicepValue.from(lastModified));
    }

    public BicepValue<String> getEtag() {
        return this.etag;
    }

    public KeyValueResource setEtag(BicepValue<String> etag) {
        this.etag.assign(etag);
        return this;
    }

    public KeyValueResource setEtag(String etag) {
        return this.setEtag(BicepValue.from(etag));
    }

    public BicepValue<String> getKeyValueName() {
        return this.keyValueName;
    }

    public KeyValueResource setKeyValueName(BicepValue<String> keyValueName) {
        this.keyValueName.assign(keyValueName);
        return this;
    }

    public KeyValueResource setKeyValueName(String keyValueName) {
        return this.setKeyValueName(BicepValue.from(keyValueName));
    }

    public BicepValue<String> getLabel() {
        return this.label;
    }

    public KeyValueResource setLabel(BicepValue<String> label) {
        this.label.assign(label);
        return this;
    }

    public KeyValueResource setLabel(String label) {
        return this.setLabel(BicepValue.from(label));
    }

    public BicepDictionary<String> getTags() {
        return this.tags;
    }

    public KeyValueResource setTags(BicepValue<Map<String,String>> tags) {
        this.tags.assign(tags);
        return this;
    }

    public KeyValueResource setTags(Map<String,String> tags) {
        return this.setTags(BicepValue.from(tags));
    }


    public static class ResourceVersions {

        public static final String V2024_05_01 = "2024-05-01";

        public static final String V2023_03_01 = "2023-03-01";

        public static final String V2022_05_01 = "2022-05-01";

    }
}
