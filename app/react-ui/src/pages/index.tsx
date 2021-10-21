import styles from './index.less';
import {Button} from "antd";

export default function IndexPage() {
  return (
    <div>
        <Button type="primary">Primary Button</Button>
        <h1 className={styles.title}>Page index</h1>
    </div>
  );
}
