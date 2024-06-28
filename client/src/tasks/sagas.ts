import {
    all,
    call,
    put,
    takeLatest,
} from 'redux-saga/effects';
import { actions } from './reducer';
import { getTasksByAgentId } from './api';
import { Task } from './types';

export function* requestTasksByAgentId(action: ReturnType<typeof actions.getTasksByAgentIdRequest>) {
    try {
        const tasks: Task[] = yield call(getTasksByAgentId, action.payload);
        yield put(actions.getTasksByAgentIdSuccess(tasks));
    } catch (error: any) {
        yield put(actions.getTasksByAgentIdFailure(error.message));
    }
}

export function* watchTasks() {
    yield all([
        takeLatest(actions.getTasksByAgentIdRequest, requestTasksByAgentId),
    ]);
}
