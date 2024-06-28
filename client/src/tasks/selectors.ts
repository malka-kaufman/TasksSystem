import { createSelector } from 'reselect';
import { AppState } from '../store/reducers';

export const getAppState = (state: AppState) => state;
export const selectTasksState = createSelector(getAppState, ({ tasksReducer }) => tasksReducer);
export const selectTasks = createSelector(selectTasksState, ({ tasks }) => tasks);
export const selectLoading = createSelector(selectTasksState, ({ loading }) => loading);
export const selectAgentId = createSelector(selectTasksState, ({ agentId }) => agentId);
