import { all } from 'redux-saga/effects';
import { watchTasks } from '../tasks/sagas';

export function* rootSaga() {
    yield all([
        watchTasks(),
    ]);
}
