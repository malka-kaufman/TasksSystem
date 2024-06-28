import {
    useEffect,
    useState,
} from 'react';
import {
    useDispatch,
    useSelector,
} from 'react-redux';
import { actions } from '../reducer';
import { selectAgentId } from '../selectors';

export function TaskUpdates() {
    const dispatch = useDispatch();
    const agentId = useSelector(selectAgentId);
    const [message, setMessage] = useState('');

    useEffect(() => {
        const ws = new WebSocket('ws://localhost:8080/new-task-assign');

        ws.onmessage = (event) => {
            setMessage(event.data);
            if (agentId && event.data === agentId.toString()) {
                dispatch(actions.getTasksByAgentIdRequest(agentId))
            }
        };

        return () => {
            ws.close();
        };
        // eslint-disable-next-line react-hooks/exhaustive-deps
    }, []);

    return (
        <div>
            <h1>Task Updates</h1>
            <p>{message}</p>
        </div>
    );
}

export default TaskUpdates;
