import {
    Container,
    makeStyles,
    Paper,
    Table,
    TableBody,
    TableCell,
    TableHead,
    TableRow,
    Theme,
} from '@material-ui/core';
import { useSelector } from 'react-redux';
import { selectTasks } from '../selectors';

export const useStyles = makeStyles(({ spacing }: Theme) => ({
    root: {
        marginTop: 2,
        overflowX: 'auto',
    },
    table: {
        minWidth: 700,
    },
}));

export function TableView() {
    const classes = useStyles();
    const rows = useSelector(selectTasks);

    return (
        <Container maxWidth='lg'>
            <Paper className={classes.root}>
                <Table className={classes.table}>
                    <TableHead>
                        <TableRow>
                            <TableCell>Task Number</TableCell>
                            <TableCell>Description</TableCell>
                            <TableCell>Status</TableCell>
                        </TableRow>
                    </TableHead>
                    <TableBody>
                        {rows.map(row => (
                            <TableRow key={row.id}>
                                <TableCell component='th' scope='row'>
                                    {row.id}
                                </TableCell>
                                <TableCell>{row.description}</TableCell>
                                <TableCell>{row.status}</TableCell>
                            </TableRow>
                        ))}
                    </TableBody>
                </Table>
            </Paper>
        </Container>
    );
}

export default TableView;
