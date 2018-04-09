package com.coffee.common.audit.service;

public interface AuditSvc<T> {

	public T load(final long id);
}
