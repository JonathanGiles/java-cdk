// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.provisioning.appconfiguration;

import java.time.OffsetDateTime;
import java.util.Map;
import com.azure.provisioning.BicepValue;
import com.azure.provisioning.BicepList;
import com.azure.provisioning.BicepDictionary;
import com.azure.provisioning.primitives.Resource;
import com.azure.provisioning.tmp.ResourceType;

public class KeyValueResource extends Resource {

    private final BicepValue<String> resourceGroupName;
    private final BicepValue<String> configStoreName;
    private final BicepValue<String> keyValueName;
    private final BicepValue<String> key;
    private final BicepValue<String> label;
    private final BicepValue<String> value;
    private final BicepValue<String> contentType;
    private final BicepValue<String> etag;
    private final BicepValue<OffsetDateTime> lastModified;
    private final BicepValue<Boolean> locked;
    private final BicepValue<Map> tags;

    public KeyValueResource(String identifierName) {
        this(identifierName, null);
    }

    public KeyValueResource(String identifierName, String resourceVersion) {
        super(identifierName, new ResourceType("Microsoft.AppConfiguration/configurationStores/keyValues"), resourceVersion);
        resourceGroupName = BicepValue.defineProperty(this, "resourceGroupName", new String[] {  }, false, true, false, null);;
        configStoreName = BicepValue.defineProperty(this, "configStoreName", new String[] {  }, false, true, false, null);;
        keyValueName = BicepValue.defineProperty(this, "keyValueName", new String[] {  }, false, true, false, null);;
        key = BicepValue.defineProperty(this, "key", new String[] {  }, false, true, false, null);;
        label = BicepValue.defineProperty(this, "label", new String[] {  }, false, true, false, null);;
        value = BicepValue.defineProperty(this, "value", new String[] {  }, false, true, false, null);;
        contentType = BicepValue.defineProperty(this, "contentType", new String[] {  }, false, true, false, null);;
        etag = BicepValue.defineProperty(this, "etag", new String[] {  }, false, true, false, null);;
        lastModified = BicepValue.defineProperty(this, "lastModified", new String[] {  }, false, false, false, null);;
        locked = BicepValue.defineProperty(this, "locked", new String[] {  }, false, true, false, null);;
        tags = BicepValue.defineProperty(this, "tags", new String[] {  }, false, false, false, null);;
    }

    public BicepValue<String> getResourceGroupName() {
        return this.resourceGroupName;
    }

    public KeyValueResource setResourceGroupName(String resourceGroupName) {
        this.resourceGroupName.assign(BicepValue.from(resourceGroupName));
        return this;
    }
    public BicepValue<String> getConfigStoreName() {
        return this.configStoreName;
    }

    public KeyValueResource setConfigStoreName(String configStoreName) {
        this.configStoreName.assign(BicepValue.from(configStoreName));
        return this;
    }
    public BicepValue<String> getKeyValueName() {
        return this.keyValueName;
    }

    public KeyValueResource setKeyValueName(String keyValueName) {
        this.keyValueName.assign(BicepValue.from(keyValueName));
        return this;
    }
    public BicepValue<String> getKey() {
        return this.key;
    }

    public KeyValueResource setKey(String key) {
        this.key.assign(BicepValue.from(key));
        return this;
    }
    public BicepValue<String> getLabel() {
        return this.label;
    }

    public KeyValueResource setLabel(String label) {
        this.label.assign(BicepValue.from(label));
        return this;
    }
    public BicepValue<String> getValue() {
        return this.value;
    }

    public KeyValueResource setValue(String value) {
        this.value.assign(BicepValue.from(value));
        return this;
    }
    public BicepValue<String> getContentType() {
        return this.contentType;
    }

    public KeyValueResource setContentType(String contentType) {
        this.contentType.assign(BicepValue.from(contentType));
        return this;
    }
    public BicepValue<String> getEtag() {
        return this.etag;
    }

    public KeyValueResource setEtag(String etag) {
        this.etag.assign(BicepValue.from(etag));
        return this;
    }
    public BicepValue<OffsetDateTime> getLastModified() {
        return this.lastModified;
    }

    public KeyValueResource setLastModified(OffsetDateTime lastModified) {
        this.lastModified.assign(BicepValue.from(lastModified));
        return this;
    }
    public BicepValue<Boolean> getLocked() {
        return this.locked;
    }

    public KeyValueResource setLocked(Boolean locked) {
        this.locked.assign(BicepValue.from(locked));
        return this;
    }
    public BicepValue<Map> getTags() {
        return this.tags;
    }

    public KeyValueResource setTags(Map tags) {
        this.tags.assign(BicepValue.from(tags));
        return this;
    }

    public static class ResourceVersions {

        public static final String V2024_05_01 = "2024-05-01";

        public static final String V2023_03_01 = "2023-03-01";

        public static final String V2022_05_01 = "2022-05-01";

    }
}
