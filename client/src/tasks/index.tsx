import { CircularProgress } from '@material-ui/core';
import { useEffect } from 'react';
import {
    useDispatch,
    useSelector,
} from 'react-redux';
import TableView from './components/TableView';

import TaskUpdates from './components/TaskUpdates';
import { actions } from './reducer';
import {
    selectAgentId,
    selectLoading,
} from './selectors';
import { LoadingState } from './types';

export const TasksViw: React.FC = () => {
    const loading = useSelector(selectLoading);
    const dispatch = useDispatch();
    const agentId = useSelector(selectAgentId);

    useEffect(() => {
        if (agentId) {
            dispatch(actions.getTasksByAgentIdRequest(agentId));
        }
        // eslint-disable-next-line react-hooks/exhaustive-deps
    }, []);

    return (
        <div>
            <h1>Tasks View</h1>
            {loading.state === LoadingState.REQUEST ? <CircularProgress color='secondary'/>
                : <TableView/>}
            <TaskUpdates/>
        </div>
    );
}
