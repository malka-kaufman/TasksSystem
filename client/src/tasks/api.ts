import axios from 'axios';
import { TASKS } from './urls';

export async function getTasks() {
    const result = await axios.get(TASKS);
    return result.data;
}

export async function getTasksByAgentId(agentId: number) {
    const result = await axios.get(`http://localhost:8080${TASKS}?agentId=${agentId}`);
    return result.data;
}
