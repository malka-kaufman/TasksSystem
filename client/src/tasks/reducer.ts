import {
    createSlice,
    PayloadAction,
} from '@reduxjs/toolkit';
import {
    LoadingState,
    State,
} from './types';

export const INITIAL_STATE: State = {
    tasks: [],
    loading: {
        state: LoadingState.IDLE,
    },
    agentId: 1,
}

export const {
    actions,
    reducer,
} = createSlice({
    name: 'tasks',
    initialState: INITIAL_STATE,
    reducers: {
        getTasksByAgentIdRequest: (state, action: PayloadAction<number>) => {
            state.loading.state = LoadingState.REQUEST
        },
        getTasksByAgentIdSuccess: (state, action) => {
            state.loading.state = LoadingState.SUCCESS;
            state.tasks = action.payload;
        },
        getTasksByAgentIdFailure: (state, action) => {
            state.loading.state = LoadingState.FAILURE;
            state.loading.info = action.payload;
        },
    },
});
