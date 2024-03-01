import { useParams } from "react-router-dom";

export default function TeamTask() {
  const { teamId, taskId } = useParams();

  return (
    <div>
      <h3>
        Team: {teamId}, Task: {taskId}
      </h3>
    </div>
  );
}
