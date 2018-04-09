package com.coffee.common.audit.service.impl;

import com.coffee.common.audit.service.AuditSvc;

public abstract class AuditSvcImpl implements AuditSvc {

	public void log(final String model, final int type, final String oldData, final String newData) {
	}
}
