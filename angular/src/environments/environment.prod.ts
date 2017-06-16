import { BackendType } from '../app/shared/backend/backend.module';

export const environment: {production: boolean, backendType: BackendType, envName: string, restPathRoot: string, restServiceRoot: string} = {
  production: true,
  backendType: BackendType.REST,
  envName: 'prod',
  restPathRoot: 'http://de-mucdevondepl01:9090/mythaistar/',
  restServiceRoot: 'http://de-mucdevondepl01:9090/mythaistar/services/rest/',
};
