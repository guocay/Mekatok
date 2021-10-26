import styles from './index.less';
import {Button} from "antd";
import {SettingDrawer} from "@ant-design/pro-layout";
import { SmileOutlined, CrownOutlined, TabletOutlined, AntDesignOutlined } from '@ant-design/icons';

export default function IndexPage() {
  return (
    <div>
        <Button type="primary">Primary Button</Button>
        <h1 className={styles.title}>Page index</h1>
        <SettingDrawer />
        <SmileOutlined />
        <CrownOutlined />
        <TabletOutlined />
        <AntDesignOutlined />

    </div>
  );
}
