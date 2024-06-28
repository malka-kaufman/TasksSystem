import { combineReducers } from 'redux';
import { StateType } from 'typesafe-actions';
import { reducer as TasksReducer } from '../tasks/reducer';

export const reducers = combineReducers({
    tasksReducer: TasksReducer,
});
export type AppState = StateType<typeof reducers>;
