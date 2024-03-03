import {useParams, useSearchParams} from "react-router-dom";
import {useCallback} from "react";

export default function Team() {
  const { teamId } = useParams();
  const [searchParams, setSearchParams] = useSearchParams();
  const message = searchParams.get('message');

  const click = useCallback(() => {
        setSearchParams({
            message: "world"
        })
  }, [searchParams]);

  return (
    <div>
      <h3>Team : {teamId}</h3>
        <button onClick={click}>click</button>
        {message && <h4>{message}</h4>}
    </div>
  );
}
