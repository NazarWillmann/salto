package ooo.jtc.rolemodel.privilege;

import javax.annotation.processing.Generated;
import ooo.jtc.rolemodel.accessobject.AccessObject;
import ooo.jtc.rolemodel.accessobject.AccessObjectBuilder;
import ooo.jtc.rolemodel.accessobject.AccessObjectDto;
import ooo.jtc.rolemodel.accessobject.AccessObjectDtoBuilder;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-01T16:00:41+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8-internal (N/A)"
)
public class PrivilegeMapperImpl implements PrivilegeMapper {

    @Override
    public Privilege toDomainModel(PrivilegeDto dto) {
        if ( dto == null ) {
            return null;
        }

        PrivilegeBuilder privilege = PrivilegeBuilder.builder();

        privilege.setId( dto.getId() );
        privilege.setVersion( dto.getVersion() );
        privilege.setName( dto.getName() );
        privilege.setUiName( dto.getUiName() );
        privilege.setDescription( dto.getDescription() );
        privilege.setAccessObjectId( dto.getAccessObjectId() );
        privilege.setAccessObject( accessObjectDtoToAccessObject( dto.getAccessObject() ) );

        return privilege.create();
    }

    @Override
    public PrivilegeDto toDto(Privilege domainModel) {
        if ( domainModel == null ) {
            return null;
        }

        PrivilegeDtoBuilder privilegeDto = PrivilegeDtoBuilder.builder();

        privilegeDto.setId( domainModel.getId() );
        privilegeDto.setVersion( domainModel.getVersion() );
        privilegeDto.setName( domainModel.getName() );
        privilegeDto.setUiName( domainModel.getUiName() );
        privilegeDto.setDescription( domainModel.getDescription() );
        privilegeDto.setAccessObjectId( domainModel.getAccessObjectId() );
        privilegeDto.setAccessObject( accessObjectToAccessObjectDto( domainModel.getAccessObject() ) );

        return privilegeDto.create();
    }

    protected AccessObject accessObjectDtoToAccessObject(AccessObjectDto accessObjectDto) {
        if ( accessObjectDto == null ) {
            return null;
        }

        AccessObjectBuilder accessObject = AccessObjectBuilder.builder();

        accessObject.setId( accessObjectDto.getId() );
        accessObject.setVersion( accessObjectDto.getVersion() );
        accessObject.setName( accessObjectDto.getName() );
        accessObject.setUiName( accessObjectDto.getUiName() );
        accessObject.setDescription( accessObjectDto.getDescription() );
        accessObject.setObjectTypeId( accessObjectDto.getObjectTypeId() );
        accessObject.setProductId( accessObjectDto.getProductId() );
        accessObject.setPath( accessObjectDto.getPath() );
        accessObject.setHasControls( accessObjectDto.getHasControls() );

        return accessObject.create();
    }

    protected AccessObjectDto accessObjectToAccessObjectDto(AccessObject accessObject) {
        if ( accessObject == null ) {
            return null;
        }

        AccessObjectDtoBuilder accessObjectDto = AccessObjectDtoBuilder.builder();

        accessObjectDto.setId( accessObject.getId() );
        accessObjectDto.setVersion( accessObject.getVersion() );
        accessObjectDto.setName( accessObject.getName() );
        accessObjectDto.setUiName( accessObject.getUiName() );
        accessObjectDto.setDescription( accessObject.getDescription() );
        accessObjectDto.setObjectTypeId( accessObject.getObjectTypeId() );
        accessObjectDto.setProductId( accessObject.getProductId() );
        accessObjectDto.setPath( accessObject.getPath() );
        accessObjectDto.setHasControls( accessObject.getHasControls() );

        return accessObjectDto.create();
    }
}
