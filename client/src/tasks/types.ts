export interface Task {
    id: number;
    description: string;
    status: string;
}

export interface State {
    tasks: Task[];
    loading: Loading;
    agentId?: number;
}

export enum LoadingState {
    IDLE = "IDLE",
    REQUEST = "REQUEST",
    SUCCESS = "DONE",
    FAILURE = "FAILURE"
}

export interface Loading {
    state: LoadingState;
    info?: string;
}
