// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.provisioning.storage.generated;

import java.util.List;
import com.azure.provisioning.storage.generated.models.SshPublicKey;
import com.azure.provisioning.storage.generated.models.PermissionScope;
import java.lang.Integer;
import com.azure.provisioning.BicepList;
import com.azure.provisioning.BicepValue;
import com.azure.provisioning.primitives.Resource;
import com.azure.provisioning.tmp.ResourceType;

public class LocalUserResource extends Resource {

    private final BicepValue<Boolean> hasSharedKey;
    private final BicepValue<String> resourceGroupName;
    private final BicepValue<String> type;
    private final BicepValue<Integer> userId;
    private final BicepValue<String> accountName;
    private final BicepValue<Boolean> hasSshKey;
    private final BicepList<PermissionScope> permissionScopes;
    private final BicepValue<String> id;
    private final BicepValue<String> username;
    private final BicepList<Integer> extendedGroups;
    private final BicepValue<Integer> groupId;
    private final BicepValue<Boolean> isNFSv3Enabled;
    private final BicepValue<String> name;
    private final BicepValue<String> homeDirectory;
    private final BicepValue<String> sid;
    private final BicepValue<Boolean> allowAclAuthorization;
    private final BicepList<SshPublicKey> sshAuthorizedKeys;
    private final BicepValue<Boolean> hasSshPassword;

    public LocalUserResource(String identifierName) {
        this(identifierName, null);
    }

    public LocalUserResource(String identifierName, String resourceVersion) {
        super(identifierName, new ResourceType("Microsoft.Storage/storageAccounts/localUsers"), resourceVersion);
        hasSharedKey = BicepValue.defineProperty(this, "hasSharedKey", new String[] { "temp", "hasSharedKey" }, false, false, false, null);
        resourceGroupName = BicepValue.defineProperty(this, "resourceGroupName", new String[] { "temp", "resourceGroupName" }, false, false, false, null);
        type = BicepValue.defineProperty(this, "type", new String[] { "temp", "type" }, false, false, false, null);
        userId = BicepValue.defineProperty(this, "userId", new String[] { "temp", "userId" }, false, false, false, null);
        accountName = BicepValue.defineProperty(this, "accountName", new String[] { "temp", "accountName" }, false, false, false, null);
        hasSshKey = BicepValue.defineProperty(this, "hasSshKey", new String[] { "temp", "hasSshKey" }, false, false, false, null);
        permissionScopes = BicepList.defineProperty(this, "permissionScopes", new String[] { "temp", "permissionScopes" }, false, false);
        id = BicepValue.defineProperty(this, "id", new String[] { "temp", "id" }, false, false, false, null);
        username = BicepValue.defineProperty(this, "username", new String[] { "temp", "username" }, false, false, false, null);
        extendedGroups = BicepList.defineProperty(this, "extendedGroups", new String[] { "temp", "extendedGroups" }, false, false);
        groupId = BicepValue.defineProperty(this, "groupId", new String[] { "temp", "groupId" }, false, false, false, null);
        isNFSv3Enabled = BicepValue.defineProperty(this, "isNFSv3Enabled", new String[] { "temp", "isNFSv3Enabled" }, false, false, false, null);
        name = BicepValue.defineProperty(this, "name", new String[] { "temp", "name" }, false, false, false, null);
        homeDirectory = BicepValue.defineProperty(this, "homeDirectory", new String[] { "temp", "homeDirectory" }, false, false, false, null);
        sid = BicepValue.defineProperty(this, "sid", new String[] { "temp", "sid" }, false, false, false, null);
        allowAclAuthorization = BicepValue.defineProperty(this, "allowAclAuthorization", new String[] { "temp", "allowAclAuthorization" }, false, false, false, null);
        sshAuthorizedKeys = BicepList.defineProperty(this, "sshAuthorizedKeys", new String[] { "temp", "sshAuthorizedKeys" }, false, false);
        hasSshPassword = BicepValue.defineProperty(this, "hasSshPassword", new String[] { "temp", "hasSshPassword" }, false, false, false, null);
    }

    public BicepValue<Boolean> getHasSharedKey() {
        return this.hasSharedKey;
    }

    public LocalUserResource setHasSharedKey(BicepValue<Boolean> hasSharedKey) {
        this.hasSharedKey.assign(hasSharedKey);
        return this;
    }

    public LocalUserResource setHasSharedKey(Boolean hasSharedKey) {
        return this.setHasSharedKey(BicepValue.from(hasSharedKey));
    }

    public BicepValue<String> getResourceGroupName() {
        return this.resourceGroupName;
    }

    public LocalUserResource setResourceGroupName(BicepValue<String> resourceGroupName) {
        this.resourceGroupName.assign(resourceGroupName);
        return this;
    }

    public LocalUserResource setResourceGroupName(String resourceGroupName) {
        return this.setResourceGroupName(BicepValue.from(resourceGroupName));
    }

    public BicepValue<String> getType() {
        return this.type;
    }

    public LocalUserResource setType(BicepValue<String> type) {
        this.type.assign(type);
        return this;
    }

    public LocalUserResource setType(String type) {
        return this.setType(BicepValue.from(type));
    }

    public BicepValue<Integer> getUserId() {
        return this.userId;
    }

    public LocalUserResource setUserId(BicepValue<Integer> userId) {
        this.userId.assign(userId);
        return this;
    }

    public LocalUserResource setUserId(Integer userId) {
        return this.setUserId(BicepValue.from(userId));
    }

    public BicepValue<String> getAccountName() {
        return this.accountName;
    }

    public LocalUserResource setAccountName(BicepValue<String> accountName) {
        this.accountName.assign(accountName);
        return this;
    }

    public LocalUserResource setAccountName(String accountName) {
        return this.setAccountName(BicepValue.from(accountName));
    }

    public BicepValue<Boolean> getHasSshKey() {
        return this.hasSshKey;
    }

    public LocalUserResource setHasSshKey(BicepValue<Boolean> hasSshKey) {
        this.hasSshKey.assign(hasSshKey);
        return this;
    }

    public LocalUserResource setHasSshKey(Boolean hasSshKey) {
        return this.setHasSshKey(BicepValue.from(hasSshKey));
    }

    public BicepList<PermissionScope> getPermissionScopes() {
        return this.permissionScopes;
    }

    public LocalUserResource setPermissionScopes(BicepValue<List<PermissionScope>> permissionScopes) {
        this.permissionScopes.assign(permissionScopes);
        return this;
    }

    public LocalUserResource setPermissionScopes(List<PermissionScope> permissionScopes) {
        return this.setPermissionScopes(BicepValue.from(permissionScopes));
    }

    public BicepValue<String> getId() {
        return this.id;
    }

    public LocalUserResource setId(BicepValue<String> id) {
        this.id.assign(id);
        return this;
    }

    public LocalUserResource setId(String id) {
        return this.setId(BicepValue.from(id));
    }

    public BicepValue<String> getUsername() {
        return this.username;
    }

    public LocalUserResource setUsername(BicepValue<String> username) {
        this.username.assign(username);
        return this;
    }

    public LocalUserResource setUsername(String username) {
        return this.setUsername(BicepValue.from(username));
    }

    public BicepList<Integer> getExtendedGroups() {
        return this.extendedGroups;
    }

    public LocalUserResource setExtendedGroups(BicepValue<List<Integer>> extendedGroups) {
        this.extendedGroups.assign(extendedGroups);
        return this;
    }

    public LocalUserResource setExtendedGroups(List<Integer> extendedGroups) {
        return this.setExtendedGroups(BicepValue.from(extendedGroups));
    }

    public BicepValue<Integer> getGroupId() {
        return this.groupId;
    }

    public LocalUserResource setGroupId(BicepValue<Integer> groupId) {
        this.groupId.assign(groupId);
        return this;
    }

    public LocalUserResource setGroupId(Integer groupId) {
        return this.setGroupId(BicepValue.from(groupId));
    }

    public BicepValue<Boolean> getIsNFSv3Enabled() {
        return this.isNFSv3Enabled;
    }

    public LocalUserResource setIsNFSv3Enabled(BicepValue<Boolean> isNFSv3Enabled) {
        this.isNFSv3Enabled.assign(isNFSv3Enabled);
        return this;
    }

    public LocalUserResource setIsNFSv3Enabled(Boolean isNFSv3Enabled) {
        return this.setIsNFSv3Enabled(BicepValue.from(isNFSv3Enabled));
    }

    public BicepValue<String> getName() {
        return this.name;
    }

    public LocalUserResource setName(BicepValue<String> name) {
        this.name.assign(name);
        return this;
    }

    public LocalUserResource setName(String name) {
        return this.setName(BicepValue.from(name));
    }

    public BicepValue<String> getHomeDirectory() {
        return this.homeDirectory;
    }

    public LocalUserResource setHomeDirectory(BicepValue<String> homeDirectory) {
        this.homeDirectory.assign(homeDirectory);
        return this;
    }

    public LocalUserResource setHomeDirectory(String homeDirectory) {
        return this.setHomeDirectory(BicepValue.from(homeDirectory));
    }

    public BicepValue<String> getSid() {
        return this.sid;
    }

    public LocalUserResource setSid(BicepValue<String> sid) {
        this.sid.assign(sid);
        return this;
    }

    public LocalUserResource setSid(String sid) {
        return this.setSid(BicepValue.from(sid));
    }

    public BicepValue<Boolean> getAllowAclAuthorization() {
        return this.allowAclAuthorization;
    }

    public LocalUserResource setAllowAclAuthorization(BicepValue<Boolean> allowAclAuthorization) {
        this.allowAclAuthorization.assign(allowAclAuthorization);
        return this;
    }

    public LocalUserResource setAllowAclAuthorization(Boolean allowAclAuthorization) {
        return this.setAllowAclAuthorization(BicepValue.from(allowAclAuthorization));
    }

    public BicepList<SshPublicKey> getSshAuthorizedKeys() {
        return this.sshAuthorizedKeys;
    }

    public LocalUserResource setSshAuthorizedKeys(BicepValue<List<SshPublicKey>> sshAuthorizedKeys) {
        this.sshAuthorizedKeys.assign(sshAuthorizedKeys);
        return this;
    }

    public LocalUserResource setSshAuthorizedKeys(List<SshPublicKey> sshAuthorizedKeys) {
        return this.setSshAuthorizedKeys(BicepValue.from(sshAuthorizedKeys));
    }

    public BicepValue<Boolean> getHasSshPassword() {
        return this.hasSshPassword;
    }

    public LocalUserResource setHasSshPassword(BicepValue<Boolean> hasSshPassword) {
        this.hasSshPassword.assign(hasSshPassword);
        return this;
    }

    public LocalUserResource setHasSshPassword(Boolean hasSshPassword) {
        return this.setHasSshPassword(BicepValue.from(hasSshPassword));
    }

}
