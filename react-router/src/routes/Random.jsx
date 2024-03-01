import {useMatch} from "react-router-dom";

export default function Random() {
    const match = useMatch("/team/:teamId/task/:taskId")

    if(match === null) {
        return (
            <div>
                <h2>Not Found</h2>
            </div>
        )
    }

    return (
        <div>
            <h3>Team: {match.params.teamId}, Task : {match.params.taskId}</h3>
        </div>
    )
}