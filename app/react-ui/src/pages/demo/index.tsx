import { Button } from "antd"
import { SmileOutlined, CrownOutlined, TabletOutlined, AntDesignOutlined } from '@ant-design/icons'

export default () => {
  return (
    <div>
        <SmileOutlined />
        <CrownOutlined />
        <TabletOutlined />
        <AntDesignOutlined />
        <br />
        <Button type="primary">Primary Button</Button>
    </div>
  );
}
