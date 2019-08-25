package org.easymis.workflow.elasticsearch.thread.v1;

import org.elasticsearch.common.recycler.Recycler.V;

public interface Callable {
	V call() throws Exception;
}
